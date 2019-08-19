package profession;

public class Dentist extends Doctor {
    private String qualification;

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void giveShots() {
        super.giveShots();
    }

    public void givesAdvice() {


    }
    public void fixTeeth() {

    }

    public Dentist(String qualification) {
        this.qualification = qualification;
    }
}
