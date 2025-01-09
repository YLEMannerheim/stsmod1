package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.util.TextureLoader;

public class BipolarPower extends AbstractPower {
    public static final String POWER_ID = "BipolarPower";
    public static final String NAME;

    public BipolarPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = "BipolarPower";
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.loadRegion("cExplosion");
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

    public void onChangeStance(AbstractStance oldStance, AbstractStance newStance) {
        if (!oldStance.ID.equals(newStance.ID)) {
            this.flash();
            this.addToBot(new DrawCardAction(this.owner, amount));
        }
    }

    public void updateDescription() {
        if (this.amount > 1) {
            this.description = "Whenever you change #yStances, draw #b" + this.amount + " cards.";
        } else {
            this.description = "Whenever you change #yStances, draw a card.";
        }
    }

    static {
        NAME = "Bipolar";
    }
}