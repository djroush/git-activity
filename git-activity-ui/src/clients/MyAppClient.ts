export type Activity = {
  id: string;
  type: string;
  actor: Actor;
  public: boolean;
  created_at: string;
}

export type Actor = {
    "id": number,
    "login": string,
    "display_login": string,
    "url": string,
    "avatar_url": string
  [property: string]: string | number
}

export interface Client {
  getActivity(
    repoOwner: string, 
    repoName: string, 
    eventType: String, 
    callback: (response: Activity[]) => void, 
    errorCallback: () => void
   ) : void;
}
