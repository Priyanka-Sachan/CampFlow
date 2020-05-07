package com.example.campflow.ui.PoliciesForYou;

public class PoliciesForYouClass {

    private String policy_id;
    private String policy_head;
    private String policy_description;
    private String policy_image;
    private String policy_web;

    public PoliciesForYouClass(String policy_id, String policy_head, String policy_description, String policy_image, String policy_web) {
        this.policy_id = policy_id;
        this.policy_head = policy_head;
        this.policy_description = policy_description;
        this.policy_image = policy_image;
        this.policy_web = policy_web;
    }

    public String getPolicy_id() {
        return policy_id;
    }

    public String getPolicy_head() {
        return policy_head;
    }

    public String getPolicy_description() {
        return policy_description;
    }

    public String getPolicy_image() {
        return policy_image;
    }

    public String getPolicy_web() {
        return policy_web;
    }

    public void setPolicy_id(String policy_id) {
        this.policy_id = policy_id;
    }

    public void setPolicy_head(String policy_head) {
        this.policy_head = policy_head;
    }

    public void setPolicy_description(String policy_description) {
        this.policy_description = policy_description;
    }

    public void setPolicy_image(String policy_image) {
        this.policy_image = policy_image;
    }

    public void setPolicy_web(String policy_web) {
        this.policy_web = policy_web;
    }
}
