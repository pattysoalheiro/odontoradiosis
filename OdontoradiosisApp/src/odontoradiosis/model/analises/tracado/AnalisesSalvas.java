/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package odontoradiosis.model.analises.tracado;

import java.util.LinkedList;
import odontoradiosis.model.analises.Ponto;

/**
 *
 * @author odontoradiosis
 */
public class AnalisesSalvas {

    public LinkedList<Ponto> listaPontos;

    public LinkedList<String> listAnalises;

    public LinkedList<String> getListAnalises() {
        return listAnalises;
    }

    public void setListAnalises(LinkedList<String> listAnalises) {
        this.listAnalises = listAnalises;
    }

    public LinkedList<Ponto> getListaPontos() {
        return listaPontos;
    }

    public void setListaPontos(LinkedList<Ponto> listaPontos) {
        this.listaPontos = listaPontos;
    }



}
