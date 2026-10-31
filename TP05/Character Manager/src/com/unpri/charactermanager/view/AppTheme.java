package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

public final class AppTheme {

    private AppTheme() {
        // Tidak perlu membuat objek AppTheme.
    }

    // =========================
    // WARNA TEMA
    // =========================
    public static final Color BACKGROUND =
            new Color(245, 247, 250);

    public static final Color SURFACE =
            Color.WHITE;

    public static final Color PRIMARY =
            new Color(40, 70, 110);

    public static final Color TEXT =
            new Color(45, 50, 60);

    public static final Color MUTED =
            new Color(110, 120, 135);

    public static final Color GOLD =
            new Color(180, 125, 20);

    // =========================
    // FONT TEMA
    // =========================
    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 22);

    public static final Font BODY_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static final Font DETAIL_FONT =
            new Font(Font.MONOSPACED, Font.PLAIN, 12);

    public static final Font EMPHASIS_FONT =
            BODY_FONT.deriveFont(Font.BOLD);

    // =========================
    // BORDER TEMA
    // =========================
    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(220, 225, 232), 1),
                    BorderFactory.createEmptyBorder(
                            12, 14, 12, 14)
            );

    // =========================
    // WARNA BERDASARKAN ROLE
    // =========================
    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return SURFACE;
        }

        if (type == CharacterType.WARRIOR) {
            return new Color(255, 235, 235);
        } else if (type == CharacterType.MAGE) {
            return new Color(235, 240, 255);
        } else if (type == CharacterType.ARCHER) {
            return new Color(232, 247, 235);
        } else if (type == CharacterType.HEALER) {
            return new Color(255, 247, 220);
        }

        return SURFACE;
    }
}
