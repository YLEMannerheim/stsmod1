package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

public class ImmuneSystemPower extends AbstractPower {
    public static final String POWER_ID = "ImmuneSystemPower";
    //private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String SINGULAR_DESCRIPTION;
    public static final String PLURAL_DESCRIPTION;

    public ImmuneSystemPower(AbstractCreature owner, int cardAmount) {
        this.name = NAME;
        this.ID = "ImmuneSystemPower";
        this.owner = owner;
        this.amount = cardAmount;
        this.updateDescription();
        this.loadRegion("confusion");

        String unPrefixed = ID;
        Texture normalTexture = TextureLoader.getPowerTexture(unPrefixed);
        Texture hiDefImage = TextureLoader.getHiDefPowerTexture(unPrefixed);
        if (hiDefImage != null)
        {
            region128 = new TextureAtlas.AtlasRegion(hiDefImage, 0, 0, hiDefImage.getWidth(), hiDefImage.getHeight());
            if (normalTexture != null)
                region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
        else if (normalTexture != null)
        {
            this.img = normalTexture;
            region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
    }

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();

            for(int i = 0; i < this.amount; ++i) {
                AbstractCard c = CardWithTagGenerationAction.returnRandomCardWithTagInCombat(CustomTags.MILK).makeCopy();
                this.addToBot(new MakeTempCardInHandAction(c, true));
            }
        }

    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        if (this.amount > 1) {
            this.description = String.format(PLURAL_DESCRIPTION, this.amount);
        } else {
            this.description = String.format(SINGULAR_DESCRIPTION, this.amount);
        }

    }

    static {
        //powerStrings = CardCrawlGame.languagePack.getPowerStrings("Magnetism");
        //NAME = powerStrings.NAME;
        NAME = "Cattle Farm";
        //SINGULAR_DESCRIPTION = powerStrings.DESCRIPTIONS[0];
        //DESCRIPTIONS = new String[] {"Put #b{0} random #yMilk card in your hand at the start of your turn."} ;
        SINGULAR_DESCRIPTION = "At the start of your turn, add #b%d random #yMilk card into your hand.";
        PLURAL_DESCRIPTION = "At the start of your turn, add #b%d random #yMilk cards into your hand.";
    }
}