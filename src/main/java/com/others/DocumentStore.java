package com.others;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class DocumentStore {

    private Collection<String> documents = new ArrayList<>();
    private int capacity;

    public DocumentStore(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<String> getDocuments() {
        // return clone
        return documents.stream().map(String::new).collect(Collectors.toList());
    }

    public void addDocument(String document) {
        if (this.documents.size() >= capacity || capacity <= 0) {
            throw new IllegalStateException();
        }
        this.documents.add(document);
    }

    @Override
    public String toString() {
        return String.format("Document store: {%d}/{%d}", documents.size(), capacity);
    }

    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("item");
        System.out.println(documentStore);
    }
}