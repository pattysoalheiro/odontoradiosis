package odontoradiosis.model.analises.relatorio;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Beto
 */
public class ReportFactory {

    private List<MedidaBean> lista = new ArrayList<MedidaBean>();

    public void addElement(MedidaBean bean) {
        lista.add(bean);
    }

    public String createReportBean() {

        JRDataSource jrds = new JRBeanCollectionDataSource(lista);
        String jasper = getClass().getResource("/odontoradiosis/model/analises/relatorio/report3.jasper").getPath();
        
        try {
            JasperFillManager.fillReportToFile(jasper, null, jrds);
            String name = System.currentTimeMillis() + ".pdf";
            String path = getClass().getResource("/odontoradiosis/model/analises/relatorio/").getPath();

            // PDF
            String jrprint = getClass().getResource("/odontoradiosis/model/analises/relatorio/report3.jrprint").getPath();
            JasperExportManager.exportReportToPdfFile(jrprint, path + name);

            return (path + name);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
