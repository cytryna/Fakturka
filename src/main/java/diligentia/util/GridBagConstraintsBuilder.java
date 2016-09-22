package diligentia.util;

import java.awt.*;

public class GridBagConstraintsBuilder {

    private static final int DEFAULT_INSET = 10;
    private final GridBagConstraints instance;

    private GridBagConstraintsBuilder(GridBagConstraints instance) {
        this.instance = instance;
    }

    public static GridBagConstraintsBuilder constraints() {
        return new GridBagConstraintsBuilder(new GridBagConstraints());
    }

    public static GridBagConstraintsBuilder fillDefaults() {
        return new GridBagConstraintsBuilder(new GridBagConstraints())
                .withFill(GridBagConstraints.BOTH)
                .withInsets(DEFAULT_INSET, DEFAULT_INSET, DEFAULT_INSET,
                        DEFAULT_INSET).withWeightX(1);
    }

    public static GridBagConstraintsBuilder horizontalConstraint() {
        return new GridBagConstraintsBuilder(new GridBagConstraints())
                .withFill(GridBagConstraints.HORIZONTAL)
                .withWeightX(1);
    }

    public static GridBagConstraintsBuilder bothConstraint() {
        return new GridBagConstraintsBuilder(new GridBagConstraints())
                .withFill(GridBagConstraints.BOTH)
                .withWeightX(1)
                .withWeightY(1);
    }

    public GridBagConstraints build() {
        return (GridBagConstraints) instance.clone();
    }

    public GridBagConstraintsBuilder withFill(int fill) {
        instance.fill = fill;
        return this;
    }

    public GridBagConstraintsBuilder withPosition(int x, int y) {
        instance.gridx = x;
        instance.gridy = y;
        return this;
    }

    public GridBagConstraintsBuilder withGridWidth(int x) {
        instance.gridwidth = x;
        return this;
    }

    public GridBagConstraintsBuilder withGridHeight(int y) {
        instance.gridheight = y;
        return this;
    }

    public GridBagConstraintsBuilder withWeightX(double weight) {
        instance.weightx = weight;
        return this;
    }

    public GridBagConstraintsBuilder withWeightY(double weight) {
        instance.weighty = weight;
        return this;
    }

    public GridBagConstraintsBuilder withAnchor(int anchor) {
        instance.anchor = anchor;
        return this;
    }

    public GridBagConstraintsBuilder withInsets(int top, int left, int bottom,
                                                int right) {
        instance.insets = new Insets(top, left, bottom, right);
        return this;
    }

    public GridBagConstraintsBuilder withInsets(Insets insets) {
        instance.insets = insets;
        return this;
    }

    public GridBagConstraintsBuilder withInsetsLeft(int left) {
        instance.insets.left = left;
        return this;
    }

    public GridBagConstraintsBuilder withInsetsRight(int right) {
        instance.insets.right = right;
        return this;
    }

    public GridBagConstraintsBuilder withInsetsLeftAndRight(int inset) {
        instance.insets.left = inset;
        instance.insets.right = inset;
        return this;
    }

    public GridBagConstraintsBuilder withInsetsBottom(int bottom) {
        instance.insets.bottom = bottom;
        return this;
    }

    public GridBagConstraintsBuilder withInsetsBottomAndRight(int inset) {
        instance.insets.bottom = inset;
        instance.insets.right = inset;
        return this;
    }

    public GridBagConstraintsBuilder withInsetsTop(int top) {
        instance.insets.top = top;
        return this;
    }

    public GridBagConstraintsBuilder withIpadY(int ipady) {
        instance.ipady = ipady;
        return this;
    }
}