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
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class ShieldOfShardsCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "ShieldOfShardsCard",
            4,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.RARE,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    public ShieldOfShardsCard() {
        super(cardInfo);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.getPower("Thorns") != null) {
            int thornsAmt = p.getPower("Thorns").amount;
            this.addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, thornsAmt), thornsAmt));
            this.addToBot(new RemoveSpecificPowerAction(p, p, "Thorns"));
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(3);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new ShieldOfShardsCard();
    }
}