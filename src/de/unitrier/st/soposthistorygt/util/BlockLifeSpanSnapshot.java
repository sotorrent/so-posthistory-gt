package de.unitrier.st.soposthistorygt.util;

public class BlockLifeSpanSnapshot{

    private int postId;
    private int postHistoryId;
    private int version;
    private int localId;
    private Integer predLocalId;
    private Integer succLocalId;

    private String comment = "";

    public BlockLifeSpanSnapshot(int postId, int postHistoryId, int version, int localId){
        this.postId = postId;
        this.postHistoryId = postHistoryId;
        this.version = version;
        this.localId = localId;
    }

    @Override
    public boolean equals(Object blockLifeSpanSnapshot){

        return
                (blockLifeSpanSnapshot instanceof BlockLifeSpanSnapshot)
            && (this.version == ((BlockLifeSpanSnapshot)blockLifeSpanSnapshot).version
            //&& this.postHistoryId == ((BlockLifeSpanSnapshot)blockLifeSpanSnapshot).postHistoryId
            && this.localId == ((BlockLifeSpanSnapshot)blockLifeSpanSnapshot).localId
            && this.postId == ((BlockLifeSpanSnapshot)blockLifeSpanSnapshot).postId);
    }


    public int getPostId() {
        return postId;
    }

    public int getPostHistoryId() {
        return postHistoryId;
    }

    public int getVersion() {
        return version;
    }

    public int getLocalId() {
        return localId;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPredLocalId() {
        return predLocalId;
    }

    public Integer getSuccLocalId() {
        return succLocalId;
    }

    public void setPredLocalId(Integer predLocalId) {
        this.predLocalId = predLocalId;
    }

    public void setSuccLocalId(Integer succLocalId) {
        this.succLocalId = succLocalId;
    }

    @Override
    public String toString(){
        return "(" + version + "," + localId + ")";
    }
}