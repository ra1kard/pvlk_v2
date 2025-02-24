package org.collection.example4;

public class MutablePerson {
    private String name;

    public MutablePerson(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MutablePerson other = (MutablePerson) obj;
        return name != null ? name.equals(other.name) : other.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MutablePerson{name='" + name + "'}";
    }

}

