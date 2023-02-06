package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;

import static dannyandjannymod.BasicMod.makeID;

public class LassoRelic extends BaseRelic {
    public static final String NAME = "LassoRelic";
    private static final int CARD_AMT = 3;
    public static final String ID = makeID(NAME);

    public LassoRelic() {
        super(ID, NAME, RelicTier.UNCOMMON, LandingSound.FLAT);
        pool = AbstractCardEnum.MILKMAN_WHITE;
    }

    @Override
    public void atBattleStart() {
        flash();
        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        for(int i = 0; i < CARD_AMT; i++) {
            AbstractCard c = CardWithTagGenerationAction.returnRandomCardWithTagInCombat(CustomTags.MILK).makeCopy();
            this.addToBot(new MakeTempCardInHandAction(c, true));
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + CARD_AMT + DESCRIPTIONS[1];
    }
}