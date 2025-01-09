package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

import java.util.Iterator;

public class DanPower extends AbstractPower {
    public static final String POWER_ID = "DanPower";
    public static final String NAME;

    public DanPower(AbstractCreature owner, int amt) {
        this.name = NAME;
        this.ID = "DanPower";
        this.owner = owner;
        this.amount = amt;
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

    @Override
    public void atStartOfTurnPostDraw() {
        Iterator var1 = AbstractDungeon.player.hand.group.iterator();
        AbstractCard c;

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            c.baseDamage += amount;
            c.baseBlock += amount;
            c.superFlash();
            c.applyPowers();
        }
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        this.description = "At the start of your turn, give all cards in hand #b" + this.amount + " more damage and #yBlock until the end of combat.";
    }

    static {
        NAME = "Autism";
    }
}