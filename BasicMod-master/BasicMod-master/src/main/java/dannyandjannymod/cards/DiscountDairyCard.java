package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.unique.SkewerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.CustomTags;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.DiscountDairyAction;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class DiscountDairyCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DiscountDairyCard",
            -1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 0;
    public static final int UPG_MAGIC = 1;

    public DiscountDairyCard() {
        super(cardInfo);
        setExhaust(true);
        setMagic(MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DiscountDairyAction(p, this.freeToPlayOnce, this.energyOnUse + this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DiscountDairyCard();
    }
}