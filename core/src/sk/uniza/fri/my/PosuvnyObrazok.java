/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.my;

/* materialy k predmetu inf2 - @autor Stefan Toth */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PosuvnyObrazok {
    private Texture textura;
    private float poziciaX = 0;
    private float poziciaY = 0;

    public PosuvnyObrazok(Texture textura, float poziciaX, float poziciaY) {
        this.textura = textura; 
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
    }
    
    public Texture getTextura() {
        return this.textura;
    }

    public float getPoziciaX() {
        return this.poziciaX;
    }

    public float getPoziciaY() {
        return this.poziciaY;
    }

    public void setPoziciaX(float poziciaX) {
        this.poziciaX = poziciaX;
    }
    
    public void setPoziciaY(float poziciaY) {
        this.poziciaY = poziciaY;
    }
        
    public void premiestni(float novaPoziciaX, float novaPoziciaY) {
        this.poziciaX = novaPoziciaX;    
        this.poziciaY = novaPoziciaY;        
    }
    
    public void premiestniNaStred(float novaPoziciaX, float novaPoziciaY) {
        this.poziciaX = novaPoziciaX - this.textura.getWidth() / 2;    
        this.poziciaY = novaPoziciaY - this.textura.getHeight() / 2;        
    }
    
    public void posunVpravo(float velkostPosunu) {
        this.poziciaX += velkostPosunu;
    }
    
    public void posunVlavo(float velkostPosunu) {
        this.poziciaX -= velkostPosunu;
    }
    
    public void posunHore(float velkostPosunu) {
        this.poziciaY += velkostPosunu;
    }
    
    public void posunDole(float velkostPosunu) {
        this.poziciaY -= velkostPosunu;
    }
    
    public void vykresli(SpriteBatch batch) {
        // Zabezpecene, aby sa obrazok nemohol dostat mimo okna - suradnica X
        if (this.poziciaX < 0) {
            this.poziciaX = 0;
        }
        if (this.poziciaX + this.textura.getWidth() > Gdx.graphics.getWidth() - 1) {
            this.poziciaX = Gdx.graphics.getWidth() - 1 - this.textura.getWidth();
        }
        
        // Zabezpecene, aby sa obrazok nemohol dostat mimo okna - suradnica Y
        if (this.poziciaY < 0) {
            this.poziciaY = 0;
        }
        if (this.poziciaY + this.textura.getHeight() > Gdx.graphics.getHeight() - 1) {
            this.poziciaY = Gdx.graphics.getHeight() - 1 - this.textura.getHeight();
        }                   
        
        batch.draw(this.textura, this.poziciaX, this.poziciaY);
    }  
}
