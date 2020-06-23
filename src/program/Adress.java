package program;

import javafx.beans.property.SimpleStringProperty;


    public class Adress {
        private final java.lang.Integer tel;
        private SimpleStringProperty name , email ;

        public Adress(String name, String email, String tel) {
            this.name = new SimpleStringProperty( name);
            this.email = new SimpleStringProperty( email);
            this.tel = new Integer(tel);
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getEmail() {
            return email.get();
        }

        public SimpleStringProperty emailProperty() {
            return email;
        }

        public void setEmail(String email) {
            this.email.set(email);
        }

        public Integer getTel() {
            return tel;
        }
    }


