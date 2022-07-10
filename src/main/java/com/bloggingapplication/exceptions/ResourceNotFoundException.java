package com.bloggingapplication.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String resourceNome;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceNome, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s",resourceNome,fieldName,fieldValue));
        this.resourceNome = resourceNome;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceNome() {
        return resourceNome;
    }

    public void setResourceNome(String resourceNome) {
        this.resourceNome = resourceNome;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(long fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException{" +
                "resourceNome='" + resourceNome + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldValue=" + fieldValue +
                '}';
    }
}
