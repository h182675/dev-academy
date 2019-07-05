package com.answerdigital.colourstest.dto;
        import com.answerdigital.colourstest.model.Colour;

        import java.util.List;
        import java.util.Objects;

public class PersonCreateDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private boolean authorised;

    private boolean enabled;

    private List<Colour> colours;


    public PersonCreateDTO(){
    }

    public PersonCreateDTO(Long id, String firstName, String lastName, boolean authorised, boolean enabled, List<Colour> colours) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorised = authorised;
        this.enabled = enabled;
        this.colours = colours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAuthorised() {
        return authorised;
    }

    public void setAuthorised(boolean authorised) {
        this.authorised = authorised;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Colour> getColours() {
        return colours;
    }

    public void setColours(List<Colour> colours) {
        this.colours = colours;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + (this.authorised ? 1 : 0);
        hash = 97 * hash + (this.enabled ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.colours);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonCreateDTO other = (PersonCreateDTO) obj;
        if (this.authorised != other.authorised) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.colours, other.colours)) {
            return false;
        }
        return true;
    }

}
