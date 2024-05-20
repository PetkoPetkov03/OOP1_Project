package bg.tu.varna.SIT.s22621616.a2.files;

import java.util.List;

public class XMLState {
    private List<String> state;

    public XMLState(List<String> content) {
        setState(content);
    }

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    public void add(String content) {
        getState().add(content);
    }

    public void find(String content) {
        
    }

}
