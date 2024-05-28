public class GenerateResources{
    private Phone phone;
    private Vector<Operators> operators;

    public GenerateResources() {
    }

    public GenerateResources(Phone phone, Vector<Operators> operators) {
        this.phone = phone;
        this.operators = operators;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Vector<Operators> getOperators() {
        return operators;
    }

    public void setOperators(Vector<Operators> operators) {
        this.operators = operators;
    }

}