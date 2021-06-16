package modelo;

public class Revista {
    int issue_id, volume, number, year;
    String date_published, title, doi, cover;

    public Revista() {
    }

    public Revista(int issue_id, int volume, int number, int year, String date_published, String title, String doi, String cover) {
        this.issue_id = issue_id;
        this.volume = volume;
        this.number = number;
        this.year = year;
        this.date_published = date_published;
        this.title = title;
        this.doi = doi;
        this.cover = cover;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Revista {\n" +
                "issue_id=" + issue_id +
                ", \nvolume=" + volume +
                ", \nnumber=" + number +
                ", \nyear=" + year +
                ", \ndate_published='" + date_published +
                ", \ntitle='" + title +
                ", \ndoi='" + doi +
                ", \ncover='" + cover +
                "\n}\n";
    }
}
