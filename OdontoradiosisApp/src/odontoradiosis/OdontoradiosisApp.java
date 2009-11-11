
package odontoradiosis;

import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyBluer;
import odontoradiosis.view.Odontoradiosis;
import javax.swing.UIManager;
import odontoradiosis.menu.abas.PanelLupa;
import odontoradiosis.view.ImagemORSPanel;
import odontoradiosis.model.effects.LupeSettings;
import odontoradiosis.view.Magnifier;

/**
 *
 * @author Beto
 */
public class OdontoradiosisApp {

    public static void main(String args[]) {

        mudarLookAndFeel();
        mudarFileChooser();
        
        LupeSettings lupeSettings = new LupeSettings();
        Magnifier magnifier = new Magnifier();        
        PanelLupa panelLupa = new PanelLupa(lupeSettings);
        ImagemORSPanel imagemORSPanel = new ImagemORSPanel(panelLupa, magnifier);


        lupeSettings.addLupeOptionListener(magnifier);

        new Odontoradiosis(imagemORSPanel, panelLupa);
    }

    private static void mudarLookAndFeel() {
        
        try {            
            if(!isWindows()) {
                PlasticXPLookAndFeel.setPlasticTheme(new SkyBluer());
                UIManager.setLookAndFeel(new PlasticXPLookAndFeel());
            }
            else
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static boolean isWindows(){

        boolean result = System.getProperty("os.name").contains("Windows") ||
                System.getProperty("os.name").contains("WINDOWS");
        return result;
    }

    private static void mudarFileChooser() {

        UIManager.put("FileChooser.lookInLabelMnemonic", "E");
        UIManager.put("FileChooser.lookInLabelText", "Examinar em");

        UIManager.put("FileChooser.saveInLabelMnemonic", "S");
        UIManager.put("FileChooser.saveInLabelText", "Salvar em");

        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");

        UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Desktop");

        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");

        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");

        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");

        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");

        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "A");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do tipo");

        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.fileDateHeaderText", "Data");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");

        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");

        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonMnemonic", "A");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");

        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.saveButtonToolTipText", "S");
        UIManager.put("FileChooser.saveButtonToolTipText", "Salvar");

        UIManager.put("FileChooser.updateButtonText", "Alterar");
        UIManager.put("FileChooser.updateButtonToolTipText", "A");
        UIManager.put("FileChooser.updateButtonToolTipText", "Alterar");

        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.helpButtonToolTipText", "A");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");

        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os arquivos");
    }
}
