package Controller;

import Model.Freelancer;
import java.util.ArrayList;
import java.util.List;

public class FreelancerController {
    private List<Freelancer> Freelancers = new ArrayList<>();
    
    public void adicionarFreelancer(Freelancer Freelancer) {
        Freelancers.add(Freelancer);
        System.out.println("Freelancer adicionado");
    }
    
    public List<Freelancer> listarFreelancers() {
        return Freelancers;
    }
}
