package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.*;
import dannyandjannymod.util.TextureLoader;

public class FortifiedCalciumPower extends AbstractPower {
    public static final String POWER_ID = "FortifiedCalciumPower";
    //private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public FortifiedCalciumPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        //this.type = PowerType.BUFF;
        this.updateDescription();
        this.loadRegion("barricade");

        String unPrefixed = ID;
        Texture normalTexture = TextureLoader.getPowerTexture(unPrefixed);
        Texture hiDefImage = TextureLoader.getHiDefPowerTexture(unPrefixed);
        if (hiDefImage != null)
        {
            region128 = new TextureAtlas.AtlasRegion(hiDefImage, 0, 0, hiDefImage.getWidth(), hiDefImage.getHeight());
            if (normalTexture != null)
                region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
        else if (normalTexture != null)
        {
            this.img = normalTexture;
            region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
    }

    public void playApplyPowerSfx() {
        CardCrawlGame.sound.play("POWER_SHACKLE", 0.05F);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    public void atEndOfTurn(boolean isPlayer) {
        if (this.owner.getPower("CalciumPower") != null) {
            int calcAmt = this.owner.getPower("CalciumPower").amount;
            if (calcAmt > 0) {
                this.flash();
                this.addToBot(new GainBlockAction(this.owner, calcAmt, Settings.FAST_MODE));
            }
        }
    }

    static {
        //powerStrings = CardCrawlGame.languagePack.getPowerStrings("OvergrownPower");
        //NAME = powerStrings.NAME;
        //DESCRIPTIONS = powerStrings.DESCRIPTIONS;
        NAME = "Fortified Calcium";
        DESCRIPTIONS = new String[] {"At the end of your turn, gain Block equal to your Calcium."} ;
    }
}