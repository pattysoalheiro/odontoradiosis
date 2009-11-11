
package odontoradiosis.model.effects;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Beto
 */
public class LupeSettings {

    private List <LupeSettingsListener>lupeOptionsListeners = new LinkedList();

    private Point pontoAtual;

    private boolean negativeActived;
    private boolean borderActived;
    private boolean equalizationActived;
    private boolean contrastModified;
    private boolean binarizationActived;
    
    private float brightnessValue;
    private float fatorContrastValue;
    private int limiarAtualValue;
    private int limiarOtimoValue;
    private float magnificationValue;
    

    public LupeSettings() {
        initialValues();
    }

    private void initialValues() {

        this.pontoAtual = new Point(0, 0);
        
        this.negativeActived = false;
        this.borderActived = false;
        this.equalizationActived = false;
        this.contrastModified = false;
        this.binarizationActived = false;
        
        this.brightnessValue = 0.0F;
        this.fatorContrastValue = 1.0F;
        this.limiarAtualValue = 50;
        this.limiarOtimoValue = 50;
        this.magnificationValue = 2.0F;
    }

    public void reset() {
        initialValues();
    }

    public boolean isBorderActived() {
        return borderActived;
    }

    public void setBorderActived(boolean borderActived) {
        this.borderActived = borderActived;
        atualizarImagem();
    }

    public float getBrightnessValue() {
        return brightnessValue;
    }

    public void setBrightnessValue(float brightnessValue) {
        this.brightnessValue = brightnessValue;
        atualizarImagem();
    }

    public boolean isContrastModified() {
        return contrastModified;
    }

    public void setContrastModified(boolean contrastModified) {
        this.contrastModified = contrastModified;
        atualizarImagem();
    }

    public boolean isEqualizationActived() {
        return equalizationActived;
    }

    public void setEqualizationActived(boolean equalizationActived) {
        this.equalizationActived = equalizationActived;
        atualizarImagem();
    }

    public float getFatorContrastValue() {
        return fatorContrastValue;
    }

    public void setFatorContrastValue(float fatorContrastValue) {
        this.fatorContrastValue = fatorContrastValue;
        atualizarImagem();
    }

    public int getLimiarAtualValue() {
        return limiarAtualValue;
    }

    public void setLimiarAtualValue(int limiarAtualValue) {
        this.limiarAtualValue = limiarAtualValue;
        atualizarImagem();
    }

    public int getLimiarOtimoValue() {
        return limiarOtimoValue;
    }

    public void setLimiarOtimoValue(int limiarOtimoValue) {
        this.limiarOtimoValue = limiarOtimoValue;
        atualizarImagem();
    }

    public boolean isNegativeActived() {
        return negativeActived;
    }

    public void setNegativeActived(boolean negativeActived) {
        this.negativeActived = negativeActived;
        atualizarImagem();
    }

    public boolean isBinarizationActived() {
        return binarizationActived;
    }

    public void setBinarizationActived(boolean binarizationActived) {
        this.binarizationActived = binarizationActived;
        atualizarImagem();
    }

    public float getMagnificationValue() {
        return magnificationValue;
    }

    public void setMagnificationValue(float magnificationValue) {
        this.magnificationValue = magnificationValue;
        atualizarImagem();
    }

    public Point getPontoAtual() {
        return pontoAtual;
    }

    public void setPontoAtual(Point pontoAtual) {
        this.pontoAtual = pontoAtual;
    }

    
    public synchronized void addLupeOptionListener(LupeSettingsListener listener){
        if(lupeOptionsListeners.contains(listener)){ return; }
        this.lupeOptionsListeners.add(listener);
    }

    private synchronized void atualizarImagem(){
        for(LupeSettingsListener listeners : this.lupeOptionsListeners){
            listeners.atualizarImagemLupa(new LupeSettingsEvent(this));
        }
    }
}
