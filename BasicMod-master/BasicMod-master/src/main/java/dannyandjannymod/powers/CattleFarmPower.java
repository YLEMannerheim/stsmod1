package dannyandjannymod.powers;

import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;

import static dannyandjannymod.BasicMod.makeID;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

public class CattleFarmPower extends AbstractPower {
    public static final String POWER_ID = "CattleFarmPower";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String SINGULAR_DESCRIPTION;
    public static final String PLURAL_DESCRIPTION;

    public CattleFarmPower(AbstractCreature owner, int cardAmount) {
        this.name = NAME;
        this.ID = "CattleFarmPower";
        this.owner = owner;
        this.amount = cardAmount;
        this.updateDescription();
        this.loadRegion("confusion");
    }

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();

            for(int i = 0; i < this.amount; ++i) {
                AbstractCard c = CardWithTagGenerationAction.returnRandomCardWithTagInCombat(CustomTags.MILK).makeCopy();
                this.addToBot(new MakeTempCardInHandAction(c, true));
            }
        }

    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        if (this.amount > 1) {
            this.description = String.format(PLURAL_DESCRIPTION, this.amount);
        } else {
            this.description = String.format(SINGULAR_DESCRIPTION, this.amount);
        }

    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Magnetism");
        NAME = powerStrings.NAME;
        //SINGULAR_DESCRIPTION = powerStrings.DESCRIPTIONS[0];
        SINGULAR_DESCRIPTION = "Put X Milk cards in your hand at the start of your turn.";
        //PLURAL_DESCRIPTION = powerStrings.DESCRIPTIONS[1];
        PLURAL_DESCRIPTION = "Put X Milk cards in your hand at the start of your turn.";
    }
}