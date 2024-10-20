package demo.pxportfolio.realestateagency.misc.agents;

import demo.pxportfolio.realestateagency.config.exception.EntityNotFoundException;
import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentRepository agentRepository;
    private static final String ENTITY_CLASS = Agent.class.getSimpleName();

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_CLASS, id.toString()));
    }

    public List<ListDto> getAllAgentsList() {
        return agentRepository.findAll()
                .stream()
                .map(ListDto::new)
                .collect(Collectors.toList());
    }
}