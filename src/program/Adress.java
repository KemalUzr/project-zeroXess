package program;

import javafx.beans.property.SimpleStringProperty;


    public class Adress {
        private SimpleStringProperty name , email ,tel;

        public Adress(String name, String email, String tel) {
            this.name = new SimpleStringProperty( name);
            this.email = new SimpleStringProperty( email);
            this.tel =  new SimpleStringProperty(tel);
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

        public String getTel() {
            return tel.get();
        }

        public SimpleStringProperty telProperty() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel.set(tel);
        }
    }


