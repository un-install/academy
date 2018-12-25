package homework2;

public class Account {
    private float overdraft;
    private String cardNumber;
    private long ownerId;

    private Account (Builder b){
        this.cardNumber = b.cardNumber;
        this.overdraft = b.overdraft;
        this.ownerId = b.ownerId;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Account{" +
                "overdraft=" + overdraft +
                ", cardNumber='" + cardNumber + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }

    public static final class Builder{
        private float overdraft;
        private String cardNumber;
        private long ownerId;

        public Builder withOverdraft (float overdraft){
            this.overdraft = overdraft;
            return this;
        }

        public Builder withCardNumber (String cardNumber){
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder withOvnerId (long ownerId){
            this.ownerId = ownerId;
            return this;
        }

        public Account build (){
            return new Account(this);
        }
    }
}
