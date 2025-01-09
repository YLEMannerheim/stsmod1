package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.util.TextureLoader;
import com.badlogic.gdx.utils.Timer;

public class SleepyPower extends AbstractPower {
    public static final String POWER_ID = "SleepyPower";
    public static final String NAME;
    private Timer.Task timerTask;

    public SleepyPower(AbstractCreature owner, int seconds) {
        this.name = NAME;
        this.ID = "SleepyPower";
        this.owner = owner;
        this.amount = seconds;
        this.type = PowerType.DEBUFF;
        this.updateDescription();
        this.loadRegion("cExplosion");

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
    @Override
    public void onInitialApplication() {
        // Start the timer when the power is applied
        startTurnTimer();
    }

    @Override
    public void onVictory() {
        stopTurnTimer();
    }

    @Override
    public void onRemove() {
        // Stop the timer when the power is removed
        stopTurnTimer();
    }

    private void startTurnTimer() {
        stopTurnTimer(); // Ensure no overlapping timers
        timerTask = Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (AbstractDungeon.player != null && AbstractDungeon.actionManager != null) {
                    if (amount <= 1) {
                        addToTop(new RemoveSpecificPowerAction(AbstractDungeon.player, AbstractDungeon.player, "SleepyPower"));
                        stopTurnTimer(); // Clean up the timer
                        addToTop(new PressEndTurnButtonAction());
                        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new SleepingPower(AbstractDungeon.player), 1));
                    } else {
                        addToTop(new ReducePowerAction(AbstractDungeon.player, AbstractDungeon.player, "SleepyPower", 1));
                    }
                }
            }
        }, 1, 1);
    }

    private void stopTurnTimer() {
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 20.0F;

        if (stackAmount < this.amount)
            this.amount = stackAmount;
    }

    public void updateDescription() {

        if (this.amount == 1) {
            this.description = "After #b" + this.amount + " second, you fall asleep.";
        } else {
            this.description = "After #b" + this.amount + " seconds, you fall asleep.";
        }
    }

    static {
        NAME = "Sleeping time!";
    }
}