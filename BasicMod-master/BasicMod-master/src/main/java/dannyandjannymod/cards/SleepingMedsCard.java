package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.BarricadePower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.powers.SleepyPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class SleepingMedsCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SleepingMedsCard",
            0,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private final int DEXTERITY = 5;

    //also, getting better at remembering that this place is a constructor :D
    public SleepingMedsCard() {
        super(cardInfo);
        setMagic(60, 20);
        setSelfRetain(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        boolean isAsleep = false;

        for(AbstractPower pow : p.powers) {
            if (pow.ID.equals("SleepingPower")) {
                isAsleep = true;
                break;
            }
        }
            if (!isAsleep) {
                this.addToBot(new ApplyPowerAction(p, p, new SleepyPower(p, magicNumber), magicNumber));
            }

        this.addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, this.DEXTERITY), this.DEXTERITY));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SleepingMedsCard();
    }
}