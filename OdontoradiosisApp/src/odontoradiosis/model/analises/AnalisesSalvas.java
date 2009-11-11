/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package odontoradiosis.model.analises;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Beto
 */
public class AnalisesSalvas implements Serializable
{
    private LinkedList<Ponto> pontos;
    private ArrayList<String> analises;
    //private ArrayList<Ator> estruturas;

    public AnalisesSalvas()
    {
        pontos = new LinkedList<Ponto>();
        analises = new ArrayList<String>();
        //estruturas = new ArrayList<Ator>();
    }

    public ArrayList<String> getAnalises()
    {
        return analises;
    }

    public void setAnalises(ArrayList<String> analises)
    {
        this.analises = analises;
    }

//    public ArrayList<Ator> getEstruturas()
//    {
//        return estruturas;
//    }
//
//    public void setEstruturas(ArrayList<Ator> estruturas)
//    {
//        this.estruturas = estruturas;
//    }

    public LinkedList<Ponto> getPontos()
    {
        return pontos;
    }

    public void setPontos(LinkedList<Ponto> pontos)
    {
        this.pontos = pontos;
    }
}
