package sk.uniza.fri.my;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;

    private float obrX;
    private float obrY;

    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.img = new Texture("badlogic.jpg");
        
        // zaciname v strede
        this.obrX = (Gdx.graphics.getWidth() - this.img.getWidth()) / 2;
        this.obrY = (Gdx.graphics.getHeight() - this.img.getHeight()) / 2;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Ak klikneme pravym tlacidlom mysi, nastavime poziciu obrazka
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            
            // Najskor si ziskame poziciu mysi (v pripade Y-ovej suradnice, 
            // musime prepocitat na suradnice obrazka, ktore zacinaju v lavom 
            // DOLNOM rohu, pricom suradnice z mysi zacinaju v lavom HORNOM rohu)
            int mysX = Gdx.input.getX();
            int mysY = Gdx.graphics.getHeight() - 1 - Gdx.input.getY();
            
            // Nastavime poziciu textury - tam, kde sme klikli, bude stred obrazka,
            // preto delime sirku a aj vysku dvojkou
            this.obrX = mysX - this.img.getWidth() / 2;
            this.obrY = mysY - this.img.getHeight() / 2;
        }
        
        // dolny okraj
        if (this.obrX < 0) {
            this.obrX = 0;
        }
        
        // horny okraj
        if (this.obrX + this.img.getWidth() > Gdx.graphics.getWidth() - 1) {
            this.obrX = Gdx.graphics.getWidth() - 1 - this.img.getWidth();
        }
        
        // lavy okraj
        if (this.obrY < 0) {
            this.obrY = 0;
        }
        
        // pravy okraj
        if (this.obrY + this.img.getHeight() > Gdx.graphics.getHeight() - 1) {
            this.obrY = Gdx.graphics.getHeight() - 1 - this.img.getHeight();
        }                   
        
        // Vykreslime obrazok na definovanej pozicii
        this.batch.begin();
        this.batch.draw(this.img, this.obrX, this.obrY);
        this.batch.end();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.img.dispose();
    }
}
