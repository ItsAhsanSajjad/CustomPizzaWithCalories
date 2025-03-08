package pzinsta.pizzeria.model.pizza;

import org.hibernate.annotations.Check;
import pzinsta.pizzeria.model.Constants;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Check(constraints = "left_pizzaside_id <> right_pizzaside_id")
public class Pizza implements Serializable {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @ManyToOne
    private Crust crust;

    @ManyToOne
    private PizzaSize size;

    @JoinColumn(unique = true, name = "left_pizzaside_id")
    @OneToOne(cascade = CascadeType.ALL)
    private PizzaSide leftPizzaSide;

    @JoinColumn(unique = true, name = "right_pizzaside_id")
    @OneToOne(cascade = CascadeType.ALL)
    private PizzaSide rightPizzaSide;

    @ManyToOne
    private BakeStyle bakeStyle;

    @ManyToOne
    private CutStyle cutStyle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public PizzaSide getLeftPizzaSide() {
        return leftPizzaSide;
    }

    public void setLeftPizzaSide(PizzaSide leftPizzaSide) {
        this.leftPizzaSide = leftPizzaSide;
    }

    public PizzaSide getRightPizzaSide() {
        return rightPizzaSide;
    }

    public void setRightPizzaSide(PizzaSide rightPizzaSide) {
        this.rightPizzaSide = rightPizzaSide;
    }

    public BakeStyle getBakeStyle() {
        return bakeStyle;
    }

    public void setBakeStyle(BakeStyle bakeStyle) {
        this.bakeStyle = bakeStyle;
    }

    public CutStyle getCutStyle() {
        return cutStyle;
    }

    public void setCutStyle(CutStyle cutStyle) {
        this.cutStyle = cutStyle;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    // Calculate total calories
    public int getTotalCalories() {
        int baseCalories = getBaseCaloriesBySize();
        int leftSideCalories = leftPizzaSide.getIngredients().stream().mapToInt(ingredient -> IngredientCalorieData.getCalories(ingredient.getName())).sum();
        int rightSideCalories = rightPizzaSide.getIngredients().stream().mapToInt(ingredient -> IngredientCalorieData.getCalories(ingredient.getName())).sum();
        return baseCalories + leftSideCalories + rightSideCalories;
    }

    // Hardcoded base calories by pizza size
    private int getBaseCaloriesBySize() {
        switch (size.getName().toLowerCase()) {
            case "small":
                return 800;
            case "medium":
                return 1000;
            case "large":
                return 1200;
            case "x-large":
                return 1400;
            default:
                return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(getCrust(), pizza.getCrust()) &&
                Objects.equals(getSize(), pizza.getSize()) &&
                Objects.equals(getLeftPizzaSide(), pizza.getLeftPizzaSide()) &&
                Objects.equals(getRightPizzaSide(), pizza.getRightPizzaSide()) &&
                Objects.equals(getBakeStyle(), pizza.getBakeStyle()) &&
                Objects.equals(getCutStyle(), pizza.getCutStyle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCrust(), getSize(), getLeftPizzaSide(), getRightPizzaSide(), getBakeStyle(), getCutStyle());
    }
}