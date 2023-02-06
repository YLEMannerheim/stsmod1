package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import dannyandjannymod.AbstractCardEnum;

import static dannyandjannymod.BasicMod.makeID;
import static org.lwjgl.util.mapped.MappedObject.foreach;

public class FrozenYogurtRelic extends BaseRelic {
    public static final String NAME = "FrozenYogurtRelic";
    private static final int BLOCK = 2;
    public static final String ID = makeID(NAME);

    public FrozenYogurtRelic() {
        super(ID, NAME, RelicTier.UNCOMMON, LandingSound.FLAT);
        pool = AbstractCardEnum.MILKMAN_WHITE;
    }

    @Override
    public void onPlayerEndTurn() {
        if (!AbstractDungeon.player.hand.group.isEmpty()) {
            int retainedCards = 0;
            for (AbstractCard c : AbstractDungeon.player.hand.group) {
                if (c.selfRetain)
                    retainedCards++;
            }
            if (retainedCards > 0) {
                this.flash();
                this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
                this.addToBot(new GainBlockAction(AbstractDungeon.player, (AbstractCreature) null, retainedCards * BLOCK));
            }
        }
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + BLOCK + DESCRIPTIONS[1];
    }
}