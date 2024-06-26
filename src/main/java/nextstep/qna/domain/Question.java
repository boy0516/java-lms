package nextstep.qna.domain;

import nextstep.qna.CannotDeleteException;
import nextstep.users.domain.NsUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private Long id;

    private String title;

    private String contents;

    private NsUser writer;

    private Answers answers;

    private boolean deleted;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime updatedDate;

    public Question(NsUser writer, String title, String contents) {
        this(0L, writer, title, contents);
    }

    public Question(Long id, NsUser writer, String title, String contents) {
        this(0L, writer, title, contents, new Answers(new ArrayList<>()), false);
    }

    public Question(Long id, NsUser writer, String title, String contents, Answers answers, boolean deleted) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.answers = answers;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public NsUser getWriter() {
        return writer;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public boolean isOwner(NsUser loginUser) {
        return writer.equals(loginUser);
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "Question [id=" + getId() + ", title=" + title + ", contents=" + contents + ", writer=" + writer + "]";
    }

    public void deleteBy(NsUser loginUser) throws CannotDeleteException{
        validDeleteAuth(loginUser);
        validOtherUserAnswer(loginUser);
        deleted = true;
        answers.delete();
    }

    private void validOtherUserAnswer(NsUser loginUser) throws CannotDeleteException {
        if (answers.isContainOtherOwner(loginUser)) {
            throw new CannotDeleteException("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
        }
    }

    private void validDeleteAuth(NsUser loginUser) throws CannotDeleteException {
        if (!this.isOwner(loginUser)) {
            throw new CannotDeleteException("질문을 삭제할 권한이 없습니다.");
        }
    }

    public List<DeleteHistory> getDeleteHistory() {
        List<DeleteHistory> deleteHistories = new ArrayList<>();
        if (!this.deleted) {
            return deleteHistories;
        }

        deleteHistories.add(new DeleteHistory(ContentType.QUESTION, id, writer, LocalDateTime.now()));
        deleteHistories.addAll(answers.getDeleteHistory());
        return deleteHistories;
    }


}
