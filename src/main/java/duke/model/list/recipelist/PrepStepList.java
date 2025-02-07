package duke.model.list.recipelist;

import duke.model.task.recipetasks.PrepStep;

import java.text.ParseException;
import java.util.ArrayList;

import static duke.common.Messages.*;

public class PrepStepList {
    private static String msg = "";
    private ArrayList<PrepStep> prepStepList;

    public PrepStepList() {
        this.prepStepList = new ArrayList<>();
    }

    /**
     * Constructor for class PrepStepList.
     *
     * @param prepStepList list containing all the preparation steps
     */
    public PrepStepList(ArrayList<PrepStep> prepStepList) {
        this.prepStepList = prepStepList;
    }

    public ArrayList<String> listPrepStep() {
        ArrayList<String> arrList = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            final int displayedIndex = i + DISPLAYED_INDEX_OFFSET;
            arrList.add(prepStepList.get(i).toString());
        }
        return arrList;
    }

    /**
     * Adds new preparation step to a recipe.
     *
     * @param prepStep the new preparation step
     */
    public void addPrepStep(String prepStep) throws ParseException {
        prepStepList.add(new PrepStep(getSize() + 1, prepStep));
        int index = prepStepList.size();
        if (index == 1) {
            msg = " prep step in the list.";
        } else {
            msg = " prep steps in the list";
        }
        System.out.println(MESSAGE_ADDED + "       " + prepStepList.get(index - 1) + "\n" + MESSAGE_ITEMS1 + index + msg);
    }

    /**
     * Deletes a preparation step according to the index
     *
     * @param i the index of preparation step to be deleted
     */
    public void deletePrepStep(int i) {
        if (prepStepList.size() - 1 <= 1) {
            msg = " prep step in the list.";
        } else {
            msg = " prep steps in the list";
        }
        System.out.println(MESSAGE_DELETE + "       " + prepStepList.get(i)
                + "\n" + MESSAGE_ITEMS1 + (prepStepList.size() - 1) + msg);
        prepStepList.remove(prepStepList.get(i));
    }

    public int getSize() {
        return prepStepList.size();
    }

    public ArrayList<PrepStep> getPrepStepList() {
        return prepStepList;
    }
}
