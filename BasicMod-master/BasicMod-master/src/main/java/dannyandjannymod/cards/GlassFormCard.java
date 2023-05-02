package dannyandjannymod.cards;

import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.GlassFormPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class GlassFormCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GlassFormCard",
            3,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 3;
    public static final int UPG_MAGIC = 1;

    public GlassFormCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        this.tags.add(BaseModCardTags.FORM);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new GlassFormPower(magicNumber), magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GlassFormCard();
    }
}