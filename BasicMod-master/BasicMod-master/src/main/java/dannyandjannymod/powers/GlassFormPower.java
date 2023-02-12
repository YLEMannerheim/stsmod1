package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

import static dannyandjannymod.BasicMod.makeID;

public class GlassFormPower extends AbstractPower {

    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    public GlassFormPower(int amount) {
        this.name = NAME;
        this.ID = "GlassFormPower";
        this.owner = AbstractDungeon.player;
        this.amount = amount;
        this.updateDescription();
        this.loadRegion("demonForm");

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

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    static {
        NAME = "Glass Form";
        DESCRIPTIONS = new String[] {"Whenever you are attacked, gain #b", " #yThorns."} ;
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != null && info.owner != this.owner) {
        //if (damageAmount < this.owner.currentHealth && damageAmount > 0 && info.owner != null && info.type == DamageInfo.DamageType.NORMAL && info.type != DamageInfo.DamageType.HP_LOSS) {
            this.flash();
            this.addToTop(new ApplyPowerAction(this.owner, this.owner, new ThornsPower(this.owner, this.amount), this.amount));
            this.updateDescription();
        }

        return damageAmount;
    }

    /*
    public void stackPower(int stackAmount) {
        this.amount += stackAmount;
        this.basePower += stackAmount;
    }
    */

}