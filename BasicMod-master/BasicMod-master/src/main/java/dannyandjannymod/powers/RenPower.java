package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.stances.AbstractStance;
import dannyandjannymod.cards.ChugCard;
import dannyandjannymod.cards.SoMeanToMeCard;
import dannyandjannymod.util.TextureLoader;

public class RenPower extends AbstractPower {
    public static final String POWER_ID = "RenPower";
    public static final String NAME;

    public RenPower(AbstractCreature owner, int Amt) {
        this.name = NAME;
        this.amount = Amt;
        this.ID = "RenPower";
        this.owner = owner;
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
            this.flash();
        this.addToBot(new MakeTempCardInHandAction(new SoMeanToMeCard(), this.amount, false));
        }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        if (this.amount > 1) {
            this.description = "Whenever you change Stance, add " + this.amount + " #ySo #yMean #yTo #yMes into your hand.";
        } else {
            this.description = "Whenever you change Stance, add a #ySo #yMean #yTo #yMe into your hand.";
        }
    }

    static {
        NAME = "Rennie";
    }
}