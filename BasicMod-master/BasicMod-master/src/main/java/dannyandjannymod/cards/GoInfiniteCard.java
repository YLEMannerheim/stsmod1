package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.powers.NoDrawPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class GoInfiniteCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GoInfiniteCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);


    public GoInfiniteCard() {
        super(cardInfo);
        setMagic(2,1);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        this.addToBot(new GainEnergyAction(this.magicNumber));
        this.addToBot(new ApplyPowerAction(p, p, new NoDrawPower(p)));
    }
    //danisgay

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GoInfiniteCard();
    }
}