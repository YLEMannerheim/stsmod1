package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.LiterallyUnplayableAction;
import dannyandjannymod.orbs.VoicesOrb;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class LiterallyUnplayableCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LiterallyUnplayableCard",
            3,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public LiterallyUnplayableCard() {
        super(cardInfo);
        setCostUpgrade(2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new LiterallyUnplayableAction());
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LiterallyUnplayableCard();
    }
}