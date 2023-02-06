package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class ShieldOfShardsCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ShieldOfShardsCard",
            2,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public ShieldOfShardsCard() {
        super(cardInfo);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.getPower("Thorns") != null) {
            int thornsAmt = p.getPower("Thorns").amount;
            this.addToBot(
                    new ApplyPowerAction(
                            p,
                            p,
                            upgraded ? new MetallicizePower(p, thornsAmt) : new PlatedArmorPower(p, thornsAmt),
                            thornsAmt));
            this.addToBot(new RemoveSpecificPowerAction(p, p, "Thorns"));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ShieldOfShardsCard();
    }
}