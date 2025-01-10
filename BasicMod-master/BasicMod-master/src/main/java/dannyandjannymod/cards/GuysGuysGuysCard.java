package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.PunchwallAction;
import dannyandjannymod.orbs.VoicesOrb;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class GuysGuysGuysCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GuysGuysGuysCard",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public GuysGuysGuysCard() {
        super(cardInfo);
        setBlock(7,2);
        setMagic(3);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++)
            this.addToBot(new GainBlockAction(p, p, this.block));
        for (int i = 0; i < magicNumber; i++) {
            this.addToBot(new ChannelAction(new VoicesOrb()));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GuysGuysGuysCard();
    }
}