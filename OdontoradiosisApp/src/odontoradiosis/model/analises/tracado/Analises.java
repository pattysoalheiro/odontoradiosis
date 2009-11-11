/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package odontoradiosis.model.analises.tracado;

import java.awt.Graphics;
import java.util.LinkedList;
import odontoradiosis.model.analises.Ponto;
import odontoradiosis.view.pontos.ORSDisplayJAI;

/**
 *
 * @author ph
 */
public interface Analises {

    public void calculaDistancia ();

    public void tracaAnalise(LinkedList<Ponto> listaPontos, ORSDisplayJAI painel, Graphics g);

    public void calculaAngulos();

    public void desenhaRetas(Graphics g);

}
