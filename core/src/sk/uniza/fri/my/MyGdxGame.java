package sk.uniza.fri.my;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {

   private SpriteBatch batch;
    private Texture textura;
    
    private PosuvnyObrazok hlavnyObrazok;
    private ArrayList<AutomatickyPosuvnyObrazok> zoznamObrazkov = new ArrayList<AutomatickyPosuvnyObrazok>();
    
    @Override
    public void create() {
        this.batch = new SpriteBatch();
        this.textura = new Texture("badlogic.jpg");
        this.hlavnyObrazok = new PosuvnyObrazok(this.textura, 0, 0);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Premiestnovanie pomocou klavesnice
        final int velkostKroku = 200;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.hlavnyObrazok.posunVpravo(velkostKroku * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.hlavnyObrazok.posunVlavo(velkostKroku * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.hlavnyObrazok.posunHore(velkostKroku * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.hlavnyObrazok.posunDole(velkostKroku * Gdx.graphics.getDeltaTime());
        }
        
        // Ked klikneme pravym tlacidlom mysi, mozeme premiestnovat hlavny obrazok
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            float poziciaMysiX = Gdx.input.getX();
            float poziciaMysiY = Gdx.graphics.getHeight() - 1 - Gdx.input.getY();
            this.hlavnyObrazok.premiestniNaStred(poziciaMysiX, poziciaMysiY);
        }            
               
        // justTouched sa vykona iba raz - keby pouzijeme namiesto neho iba isTouched, 
        // vytvorarali by sme niekolko objektov az dokial nepustime tlacidlo mysi
        if (Gdx.input.justTouched() && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            float poziciaMysiX = Gdx.input.getX();
            float poziciaMysiY = Gdx.graphics.getHeight() - 1 - Gdx.input.getY();
            this.zoznamObrazkov.add(new AutomatickyPosuvnyObrazok(this.textura, poziciaMysiX, poziciaMysiY));            
        }        
 
        this.batch.begin();
        // Vykreslime vsetky pridane obrazky
        for (AutomatickyPosuvnyObrazok mojObrazok : this.zoznamObrazkov) {
            mojObrazok.vykresli(this.batch);
        }
        // Vykreslime hlavny obrazok
        this.hlavnyObrazok.vykresli(this.batch);
        this.batch.end();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.textura.dispose();
    }
}
