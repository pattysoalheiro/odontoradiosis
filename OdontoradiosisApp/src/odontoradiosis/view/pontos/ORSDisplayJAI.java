
package odontoradiosis.view.pontos;

import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.sun.media.jai.widget.DisplayJAI;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.jai.PlanarImage; 
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import odontoradiosis.menu.abas.PanelAnalisesEvent;
import odontoradiosis.menu.abas.PanelAnalisesListener;
import odontoradiosis.model.analises.Analise;
import odontoradiosis.model.analises.AnalisesSalvas;
import odontoradiosis.model.analises.Ponto;
import odontoradiosis.model.analises.tracado.AnaliseHarvold;
import odontoradiosis.model.analises.tracado.AnaliseSteiner;
import odontoradiosis.model.analises.tracado.AnaliseWylie;
import odontoradiosis.model.analises.tracado.Tracado;

/**
 *
 * @author Lucas
 */
public class ORSDisplayJAI extends DisplayJAI implements PanelAnalisesListener {

    private Collection <ORSDisplayListener> listeners = new ArrayList<ORSDisplayListener>();
    private LinkedList<Ponto> pontosSalvos = new LinkedList<Ponto>();
    private ArrayList<String> analisesSalvas = new ArrayList<String>();

    private ORSPolygon polygon;
    
    private Analise analiseAtual;
    private boolean analiseEditing;
    private Ponto pontoAtual;
    
    private Tracado tracadoAtual;
        
    private MarcarPontoListener marcarPontoListener;
    private MoverPontosListener moverPontosListener;

    
    public ORSDisplayJAI(PlanarImage image) {
        super();
        
        if(image != null)  this.set(image);

        marcarPontoListener = new MarcarPontoListener(this.getGraphics());
        moverPontosListener = new MoverPontosListener(this.getGraphics());
        analiseAtual = null;
        analiseEditing = false;
    }

    public ORSDisplayJAI() {
        this(null);
    }
    

    public ORSPolygon getPolygon() {
        return polygon;
    }

    public void setPolygon(ORSPolygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void set(RenderedImage im) {
        super.set(im);
        this.repaint();
    }

    public synchronized void addListener(ORSDisplayListener l) {
        if(!listeners.contains(l))
            listeners.add(l);
    }

    public synchronized void removeListener(ORSDisplayListener l) {
        listeners.remove(l);
    }

    private synchronized void disparaMarcouPonto(Ponto ponto) {
        for(ORSDisplayListener listener : this.listeners)
            listener.marcouPonto(new ORSDisplayEvent(this, ponto));
    }

    private synchronized void disparaCancelouAnalise() {
        for(ORSDisplayListener listener : this.listeners)
            listener.cancelouAnalise(new ORSDisplayEvent(this));
    }

    /********************************************/
    /********************************************/

    public void iniciarMarcarPontos(PanelAnalisesEvent event) {
        analiseAtual = new Analise(event.getNomeAnalise());
    }

    public void marcarPonto(PanelAnalisesEvent event) {
        if(event.isMarcacaoAtiva()) {
            analiseEditing = true;
            pontoAtual = event.getPonto();            
            addPonto(pontoAtual);
            addAnalise(event.getNomeAnalise());
            this.addMouseListener(marcarPontoListener);
            this.addMouseMotionListener(marcarPontoListener);
        }
        else {
            analiseEditing = false;
            pontoAtual = null;
            this.removeMouseListener(marcarPontoListener);
            this.removeMouseMotionListener(marcarPontoListener);
        }
    }
    
    public void moverPontos(PanelAnalisesEvent event) {
        if(event.isMoverAtivo()) {
            this.addMouseListener(moverPontosListener);
            this.addMouseMotionListener(moverPontosListener);
        }
        else {
            this.removeMouseListener(moverPontosListener);
            this.removeMouseMotionListener(moverPontosListener);
        }
    }
    
    public void salvarPontos(PanelAnalisesEvent event)
    {
        AnalisesSalvas salvaAnalises = new AnalisesSalvas();
        salvaAnalises.setPontos(pontosSalvos);
        salvaAnalises.setAnalises(analisesSalvas);
       
        OutputStream out;
        InputStream in;

        try
        {
            out = new OutputStream(new FileOutputStream("src/Pacientes/teste.txt"));

            ObjectOutputStream output;
            try
            {
                output = new ObjectOutputStream(out);
                output.writeObject(salvaAnalises);
                output.close();
            } 
            catch (IOException ex)
            {
                Logger.getLogger(ORSDisplayJAI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(ORSDisplayJAI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            in = new InputStream(new FileInputStream("src/Pacientes/teste.txt"));
            try
            {
                ObjectInputStream o = new ObjectInputStream(in);
                try {
                    System.out.println(o.readObject());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ORSDisplayJAI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            catch (IOException ex)
            {
                Logger.getLogger(ORSDisplayJAI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ORSDisplayJAI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addAnalise(String analise)
    {
        for(int i = 0; i < analisesSalvas.size(); i++)
            if(!analisesSalvas.contains(analise))
                analisesSalvas.add(analise);
    }

    public void addPonto(Ponto ponto)
    {
        for(int i = 0; i < pontosSalvos.size(); i++)
            if(!pontosSalvos.contains(ponto))
                pontosSalvos.add(ponto);
    }
    
    public void cancelarMarcarPontos(PanelAnalisesEvent event) {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja cancelar essa marcação de pontos?",
                "Voltar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if(resposta == JOptionPane.YES_OPTION) {
            analiseAtual = null;
            tracadoAtual = null;
            
            for (MouseListener listener : this.getMouseListeners())
                this.removeMouseListener(listener);
            for (MouseMotionListener listener : this.getMouseMotionListeners())
                this.removeMouseMotionListener(listener);

            disparaCancelouAnalise();
            repaint();
        }
    }

    public void gerarTracado(PanelAnalisesEvent event) {

        ArrayList<Ponto> pontos = analiseAtual.getPontos();
        int PCms = 60;
        String nomeAnalise = analiseAtual.getNomeAnalise();

        if(nomeAnalise.equals("Harvold"))
            tracadoAtual = new AnaliseHarvold(pontos, PCms);
        else if(nomeAnalise.equals("Wylie"))
            tracadoAtual = new AnaliseWylie(pontos, PCms);
        else if(nomeAnalise.equals("Steiner"))
            tracadoAtual = new AnaliseSteiner(pontos, PCms, this);

        tracadoAtual.executarTracado();
        repaint();
        
        
        /* Gerar Relatorio */
        int result = JOptionPane.showConfirmDialog(null, "Deseja gerar o relatório da análise feita?",
                    "Relatório da Análise", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(result == JOptionPane.YES_OPTION) {
            String path = tracadoAtual.gerarRelatorio();
            try {
                Desktop.getDesktop().open(new File(path));
            }
            catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao abrir o relatório.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        /* Gerar Relatorio */
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        float escala = AnaliseSettings.getInstance().getEscala();

        if(analiseEditing && analiseAtual != null) {

            if(tracadoAtual != null)
                tracadoAtual.paintTracado(g);

            ArrayList<Ponto> pontos = analiseAtual.getPontos();

            for (Ponto ponto : pontos) {
                int x = ponto.x;
                int y = ponto.y;

                g.setColor(Color.YELLOW);
                g.fillOval((int) (x * escala - 3), (int) (y * escala - 3), 7, 7);
                g.drawString(ponto.getSigla(), (int) (x * escala - 2), (int) (y * escala + 15));
            }
        }
    }

//*****************************************************************************
//*****************************************************************************
    
    private class MarcarPontoListener extends MouseInputAdapter {

        private Graphics graphics;

        public MarcarPontoListener(Graphics g) {
            this.graphics = g;
        }

        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();

            float escala = AnaliseSettings.getInstance().getEscala();
            pontoAtual.setLocation(e.getX(), e.getY());
            pontoAtual.x = (int)(pontoAtual.x/escala);
            pontoAtual.y = (int)(pontoAtual.y/escala);
            
            analiseAtual.getPontos().add(pontoAtual);                

            removeMouseListener(marcarPontoListener);
            removeMouseMotionListener(marcarPontoListener);

            disparaMarcouPonto(pontoAtual);
            repaint();
        }
    }
    
    private class MoverPontosListener extends MouseInputAdapter {

        private Graphics graphics;
        private boolean movendoPonto;
        private Ponto pontoMovido;

        public MoverPontosListener(Graphics graphics) {
            this.graphics = graphics;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            Point pontoClicado = e.getPoint();
            float escala = AnaliseSettings.getInstance().getEscala();
            pontoClicado.x = (int) (pontoClicado.x/escala);
            pontoClicado.y = (int) (pontoClicado.y/escala);

            for (int i = 0; i < analiseAtual.getPontos().size(); i++) {
                Ponto pontoLista = (Ponto) analiseAtual.getPontos().get(i);
                
                if (findPoint(pontoLista, pontoClicado)) {
                    movendoPonto = true;
                    pontoMovido = analiseAtual.getPontos().get(i);
                    break;
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            float escala = AnaliseSettings.getInstance().getEscala();

            if(movendoPonto)
                pontoMovido.move((int) (e.getPoint().x / escala), (int) (e.getPoint().y / escala));
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(movendoPonto) {
                movendoPonto = false;
                pontoMovido = null;
            }
        }

        private boolean findPoint(Point pontoLista, Point pontoClick) {
            int dist;
            dist = (int) pontoClick.distance(pontoLista.x, pontoLista.y);

            if (dist <= 7)
                return true;
            else
                return false;
        }
    }
}

