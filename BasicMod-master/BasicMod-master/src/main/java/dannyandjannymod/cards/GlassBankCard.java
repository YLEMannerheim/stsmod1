package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.FemurAction;
import dannyandjannymod.GlassBankAction;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class GlassBankCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GlassBankCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 5;
    public static final int UPG_MAGIC = -1;

    public GlassBankCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GlassBankAction(this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GlassBankCard();
    }
}