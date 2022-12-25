package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.CustomTags;
import dannyandjannymod.powers.OvergrownPower;
import dannyandjannymod.powers.SpareBucketPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class OvergrownCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "OvergrownCard",
            1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    public OvergrownCard() {
        super(cardInfo);
        setInnate(false, true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new OvergrownPower(p), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new OvergrownCard();
    }
}