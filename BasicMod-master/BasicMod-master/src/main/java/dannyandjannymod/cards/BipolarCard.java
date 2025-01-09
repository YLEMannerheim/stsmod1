package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.MentalFortressPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.BipolarPower;
import dannyandjannymod.powers.DanPower;
import dannyandjannymod.stances.DepressedStance;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class BipolarCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BipolarCard",
            3,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 1;

    public BipolarCard() {
        super(cardInfo);
        setMagic(MAGIC);
        setInnate(false, true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
            this.addToBot(new ApplyPowerAction(p, p, new BipolarPower(p, this.magicNumber), this.magicNumber));
            this.addToBot(new ChangeStanceAction(DepressedStance.STANCE_ID));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new BipolarCard();
    }
}