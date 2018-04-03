/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.my;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

/* materialy k predmetu inf2 - @autor Stefan Toth */

public class AutomatickyPosuvnyObrazok extends PosuvnyObrazok {

    private final int rychlost;
    private int smerX = 1;
    private int smerY = 1;
    
    public AutomatickyPosuvnyObrazok(Texture textura, float poziciaX, float poziciaY) {
        super(textura, poziciaX, poziciaY);

        Random random = new Random();
        this.rychlost = 50 + random.nextInt(300);
        this.smerX = random.nextBoolean() ? -1 : 1;
        this.smerY = random.nextBoolean() ? -1 : 1;
    }
    
    @Override
    public void vykresli(SpriteBatch batch) {
        float poziciaX = this.getPoziciaX() + this.smerX * this.rychlost * Gdx.graphics.getDeltaTime();    
        float poziciaY = this.getPoziciaY() + this.smerY * this.rychlost * Gdx.graphics.getDeltaTime();
        
        if (poziciaX < 0) {         
            this.smerX = this.smerX * -1;
        }
        if (poziciaX + this.getTextura().getWidth() > Gdx.graphics.getWidth() - 1) {
            this.smerX = this.smerX * -1;
        }
        
        if (poziciaY < 0) {
            this.smerY = this.smerY * -1;
        }
        if (poziciaY + this.getTextura().getHeight() > Gdx.graphics.getHeight() - 1) {
            this.smerY = this.smerY * -1;
        }    

        premiestni(poziciaX, poziciaY);
        
        super.vykresli(batch);
    }    
}
