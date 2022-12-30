package dannyandjannymod.relics;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;

import static dannyandjannymod.BasicMod.makeID;

public class ButterDishRelic extends BaseRelic {
    public static final String NAME = "ButterDishRelic";

    public static final String ID = makeID(NAME);

    public ButterDishRelic() {
        super(ID, NAME, RelicTier.RARE, LandingSound.FLAT);
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}