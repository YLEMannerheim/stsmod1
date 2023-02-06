package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

import java.util.Iterator;

public class MorningRoundsPower extends AbstractPower {
    public static final String POWER_ID = "CattleFarmPower";
    //private static final PowerStrings powerStrings;
    public static final String NAME;

    public MorningRoundsPower(AbstractCreature owner, int cardAmount) {
        this.name = NAME;
        this.ID = "MorningRoundsPower";
        this.owner = owner;
        this.amount = cardAmount;
        this.updateDescription();
        this.loadRegion("confusion");

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

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();

            Iterator var4 = AbstractDungeon.getMonsters().monsters.iterator();
            while(var4.hasNext()) {
                AbstractMonster mon = (AbstractMonster)var4.next();
                if (!mon.isDeadOrEscaped()) {

                    int deliveranceAmt = mon.hasPower("DeliverancePower") ? mon.getPower("DeliverancePower").amount : 0;
                    int amtToApply = this.amount - deliveranceAmt;
                    if (amtToApply > 0)
                        addToBot(new ApplyPowerAction(mon, AbstractDungeon.player, new DeliverancePower(mon, amtToApply), amtToApply));
                }
            }
        }

    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        this.description = String.format(DESCRIPTIONS[0], this.amount, this.amount);
    }

    static {
        //powerStrings = CardCrawlGame.languagePack.getPowerStrings("Magnetism");
        //NAME = powerStrings.NAME;
        NAME = "Morning Rounds";
        //SINGULAR_DESCRIPTION = powerStrings.DESCRIPTIONS[0];
        DESCRIPTIONS = new String[]{"At the start of your turn, ALL enemies with less than #b%d #yDeliverance have their #yDeliverance increased to #b%d."};
    }
}